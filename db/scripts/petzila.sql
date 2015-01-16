-- MySQL Script generated by MySQL Workbench
-- vie 16 ene 2015 09:53:20 CST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema petzila
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `petzila` ;

-- -----------------------------------------------------
-- Schema petzila
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `petzila` DEFAULT CHARACTER SET utf8 ;
USE `petzila` ;

-- -----------------------------------------------------
-- Table `petzila`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petzila`.`user` ;

CREATE TABLE IF NOT EXISTS `petzila`.`user` (
  `user_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `activation_key` VARCHAR(500) NULL,
  `active` TINYINT(1) NOT NULL,
  `is_founder` TINYINT(1) NOT NULL,
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(500) NOT NULL,
  `salt` VARCHAR(500) NOT NULL,
  `signup_type` VARCHAR(100) NOT NULL,
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(1000) NULL,
  `email` VARCHAR(200) NOT NULL,
  `profile_picture` VARCHAR(500) NULL,
  `country` VARCHAR(200) NULL,
  `city` VARCHAR(200) NULL,
  `zip_code` INT NULL,
  `updated_at` DATE NULL,
  `temporal_password` VARCHAR(500) NULL,
  `social_network_id` VARCHAR(1000) NULL,
  `temporal_password_expiration` DATE NULL,
  `facebook_token` VARCHAR(1000) NULL,
  `merge_type` VARCHAR(45) NULL,
  `created_at` DATE NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `user_id_UNIQUE` ON `petzila`.`user` (`user_id` ASC);


-- -----------------------------------------------------
-- Table `petzila`.`pet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petzila`.`pet` ;

CREATE TABLE IF NOT EXISTS `petzila`.`pet` (
  `pet_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL,
  `age` VARCHAR(20) NOT NULL,
  `species` VARCHAR(20) NOT NULL,
  `size` VARCHAR(20) NOT NULL,
  `profile_picture` VARCHAR(500) NULL,
  `description` VARCHAR(1000) NULL,
  `breed` VARCHAR(200) NULL,
  `other` VARCHAR(1000) NULL,
  `gender` VARCHAR(50) NOT NULL,
  `food` VARCHAR(100) NULL,
  `website` VARCHAR(500) NULL,
  `updated_at` DATE NULL,
  `owner` BIGINT UNSIGNED NOT NULL,
  `created_at` DATE NOT NULL,
  PRIMARY KEY (`pet_id`),
  CONSTRAINT `fk_pet_user`
    FOREIGN KEY (`owner`)
    REFERENCES `petzila`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_pet_user_idx` ON `petzila`.`pet` (`owner` ASC);

CREATE UNIQUE INDEX `user_id_UNIQUE` ON `petzila`.`pet` (`pet_id` ASC);


-- -----------------------------------------------------
-- Table `petzila`.`post`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petzila`.`post` ;

CREATE TABLE IF NOT EXISTS `petzila`.`post` (
  `post_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(500) NOT NULL,
  `content_url` VARCHAR(500) NOT NULL,
  `pet_id` BIGINT UNSIGNED NOT NULL,
  `updated_at` DATE NULL,
  `created_at` DATE NULL,
  PRIMARY KEY (`post_id`),
  CONSTRAINT `fk_post_pet1`
    FOREIGN KEY (`pet_id`)
    REFERENCES `petzila`.`pet` (`pet_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_post_pet1_idx` ON `petzila`.`post` (`pet_id` ASC);


-- -----------------------------------------------------
-- Table `petzila`.`device`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petzila`.`device` ;

CREATE TABLE IF NOT EXISTS `petzila`.`device` (
  `device_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `os` VARCHAR(50) NOT NULL,
  `key` VARCHAR(1000) NOT NULL,
  `user_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`device_id`),
  CONSTRAINT `fk_device_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `petzila`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_device_user1_idx` ON `petzila`.`device` (`user_id` ASC);


-- -----------------------------------------------------
-- Table `petzila`.`pet_follow`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petzila`.`pet_follow` ;

CREATE TABLE IF NOT EXISTS `petzila`.`pet_follow` (
  `pet_follow_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT UNSIGNED NOT NULL,
  `pet_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`pet_follow_id`),
  CONSTRAINT `fk_following_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `petzila`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_following_pet1`
    FOREIGN KEY (`pet_id`)
    REFERENCES `petzila`.`pet` (`pet_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_following_user1_idx` ON `petzila`.`pet_follow` (`user_id` ASC);

CREATE INDEX `fk_following_pet1_idx` ON `petzila`.`pet_follow` (`pet_id` ASC);


-- -----------------------------------------------------
-- Table `petzila`.`post_like`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petzila`.`post_like` ;

CREATE TABLE IF NOT EXISTS `petzila`.`post_like` (
  `post_like_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT UNSIGNED NOT NULL,
  `post_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`post_like_id`),
  CONSTRAINT `fk_likes_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `petzila`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_post_like_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `petzila`.`post` (`post_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_likes_user1_idx` ON `petzila`.`post_like` (`user_id` ASC);

CREATE INDEX `fk_post_like_post1_idx` ON `petzila`.`post_like` (`post_id` ASC);

CREATE UNIQUE INDEX `post_like_id_UNIQUE` ON `petzila`.`post_like` (`post_like_id` ASC);


-- -----------------------------------------------------
-- Table `petzila`.`comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petzila`.`comment` ;

CREATE TABLE IF NOT EXISTS `petzila`.`comment` (
  `comment_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(500) NOT NULL,
  `created_at` DATE NOT NULL,
  `user_id` BIGINT UNSIGNED NOT NULL,
  `post_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`comment_id`),
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `petzila`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_comment_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `petzila`.`post` (`post_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_comment_user1_idx` ON `petzila`.`comment` (`user_id` ASC);

CREATE INDEX `fk_comment_post1_idx` ON `petzila`.`comment` (`post_id` ASC);

CREATE UNIQUE INDEX `comment_id_UNIQUE` ON `petzila`.`comment` (`comment_id` ASC);


-- -----------------------------------------------------
-- Table `petzila`.`notification`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petzila`.`notification` ;

CREATE TABLE IF NOT EXISTS `petzila`.`notification` (
  `notification_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(50) NOT NULL,
  `description` VARCHAR(200) NULL,
  `status` VARCHAR(50) NOT NULL,
  `pet_id` BIGINT UNSIGNED NOT NULL,
  `post_id` BIGINT UNSIGNED NOT NULL,
  `owner` BIGINT UNSIGNED NOT NULL,
  `created_by` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`notification_id`),
  CONSTRAINT `fk_notification_pet1`
    FOREIGN KEY (`pet_id`)
    REFERENCES `petzila`.`pet` (`pet_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notification_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `petzila`.`post` (`post_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notification_owner`
    FOREIGN KEY (`owner`)
    REFERENCES `petzila`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_notification_created_by`
    FOREIGN KEY (`created_by`)
    REFERENCES `petzila`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_notification_pet1_idx` ON `petzila`.`notification` (`pet_id` ASC);

CREATE INDEX `fk_notification_post1_idx` ON `petzila`.`notification` (`post_id` ASC);

CREATE INDEX `fk_notification_owner_idx` ON `petzila`.`notification` (`owner` ASC);

CREATE INDEX `fk_notification_created_by_idx` ON `petzila`.`notification` (`created_by` ASC);


-- -----------------------------------------------------
-- Table `petzila`.`post_report`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petzila`.`post_report` ;

CREATE TABLE IF NOT EXISTS `petzila`.`post_report` (
  `post_report_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(500) NULL,
  `ip_address` VARCHAR(50) NULL,
  `post_id` BIGINT UNSIGNED NOT NULL,
  `user_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`post_report_id`),
  CONSTRAINT `fk_post_report_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `petzila`.`post` (`post_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_post_report_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `petzila`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_post_report_post1_idx` ON `petzila`.`post_report` (`post_id` ASC);

CREATE INDEX `fk_post_report_user1_idx` ON `petzila`.`post_report` (`user_id` ASC);


-- -----------------------------------------------------
-- Table `petzila`.`petzi_connect`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petzila`.`petzi_connect` ;

CREATE TABLE IF NOT EXISTS `petzila`.`petzi_connect` (
  `petzi_connect_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `mac_address` VARCHAR(100) NOT NULL,
  `petzi_ip` VARCHAR(100) NULL,
  `name` VARCHAR(45) NULL,
  `default` TINYINT(1) NOT NULL DEFAULT 0,
  `user_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`petzi_connect_id`),
  CONSTRAINT `fk_PetziConnect_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `petzila`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_PetziConnect_user1_idx` ON `petzila`.`petzi_connect` (`user_id` ASC);


-- -----------------------------------------------------
-- Table `petzila`.`session_request`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petzila`.`session_request` ;

CREATE TABLE IF NOT EXISTS `petzila`.`session_request` (
  `session_request_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `ios_publish_point` VARCHAR(500) NULL,
  `android_publish_points` VARCHAR(500) NULL,
  `web_publish_points` VARCHAR(500) NULL,
  `ms_nonce` VARCHAR(200) NULL,
  `audio_port` VARCHAR(45) NULL,
  `session_server_ip` VARCHAR(500) NULL,
  `session_server_password` VARCHAR(500) NULL,
  `session_server_nonce` VARCHAR(500) NULL,
  `ready` TINYINT(1) NOT NULL DEFAULT 0,
  `processed` TINYINT(1) NOT NULL DEFAULT 0,
  `timestamp` DATE NULL,
  `need_process` TINYINT(1) NOT NULL DEFAULT 0,
  `invalid` TINYINT(1) NOT NULL DEFAULT 0,
  `petzi_connect_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`session_request_id`),
  CONSTRAINT `fk_session_request_petzi_connect1`
    FOREIGN KEY (`petzi_connect_id`)
    REFERENCES `petzila`.`petzi_connect` (`petzi_connect_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_session_request_petzi_connect1_idx` ON `petzila`.`session_request` (`petzi_connect_id` ASC);


-- -----------------------------------------------------
-- Table `petzila`.`IndieUsers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petzila`.`IndieUsers` ;

CREATE TABLE IF NOT EXISTS `petzila`.`IndieUsers` (
  `indie_user_id` BIGINT UNSIGNED NOT NULL,
  `email` VARCHAR(200) NULL,
  PRIMARY KEY (`indie_user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
