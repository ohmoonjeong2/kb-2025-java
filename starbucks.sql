-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema starbucks
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `customer` ;

CREATE TABLE IF NOT EXISTS `customer` (
  `id` VARCHAR(5) NOT NULL,
  `pwd` VARCHAR(5) NULL DEFAULT NULL,
  `name` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `order_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `order_info` ;

CREATE TABLE IF NOT EXISTS `order_info` (
  `order_info_no` INT NOT NULL,
  `order_id` VARCHAR(5) NOT NULL,
  `order_dt` DATETIME NULL,
  PRIMARY KEY (`order_info_no`),
  INDEX `fk_order_info_customer_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_info_customer`
    FOREIGN KEY (`order_id`)
    REFERENCES `starbucks`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product` ;

CREATE TABLE IF NOT EXISTS `product` (
  `prod_no` VARCHAR(5) NOT NULL,
  `prod_name` VARCHAR(20) NULL DEFAULT NULL,
  `prod_price` INT NULL DEFAULT NULL,
  PRIMARY KEY (`prod_no`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `order_line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `order_line` ;

CREATE TABLE IF NOT EXISTS `order_line` (
  `order_line_no` INT NOT NULL,
  `order_prod_no` VARCHAR(5) NOT NULL,
  `order_quantity` INT NULL,
  PRIMARY KEY (`order_line_no`, `order_prod_no`),
  INDEX `fk_order_line_product1_idx` (`order_prod_no` ASC) VISIBLE,
  INDEX `fk_order_line_order_info1_idx` (`order_line_no` ASC) VISIBLE,
  CONSTRAINT `fk_order_line_product1`
    FOREIGN KEY (`order_prod_no`)
    REFERENCES `starbucks`.`product` (`prod_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_line_order_info1`
    FOREIGN KEY (`order_line_no`)
    REFERENCES `order_info` (`order_info_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
