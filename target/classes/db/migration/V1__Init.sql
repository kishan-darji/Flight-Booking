CREATE TABLE `audit_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `action` varchar(255) DEFAULT NULL,  
  `entity_name` varchar(255) DEFAULT NULL,
  `ref_table_id` int(11) DEFAULT NULL,
  `content` longtext DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `flight_booking`.`flight` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `flight_name` VARCHAR(255) NOT NULL,
  `created_dttm` TIMESTAMP NULL DEFAULT NULL,
  `last_updated_dttm` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `flight_booking`.`booking` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `flight_id` INT NULL,
  `booking_time` TIMESTAMP NULL DEFAULT NULL,
  `passenger_name` VARCHAR(255) NOT NULL,
  `seat_number` VARCHAR(255) NOT NULL,
  `created_dttm` TIMESTAMP NULL DEFAULT NULL,
  `last_updated_dttm` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_FLIGHT_BOOKING_INDEX_idx` (`flight_id` ASC) INVISIBLE,
  CONSTRAINT `FK_FLIGHT_BOOKING_INDEX`
    FOREIGN KEY (`flight_id`)
    REFERENCES `flight_booking`.`flight` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

 CREATE TABLE `flight_booking`.`schedule` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `flight_id` INT NULL,
  `schedule_time` TIMESTAMP NULL DEFAULT NULL,
  `schedule_seat` integer NOT NULL,
  `available_seat` integer NOT NULL,
  `created_dttm` TIMESTAMP NULL DEFAULT NULL,
  `last_updated_dttm` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_FLIGHT_SCHEDULE_INDEX_idx` (`flight_id` ASC) INVISIBLE,
  CONSTRAINT `FK_FLIGHT_SCHEDULE_INDEX`
    FOREIGN KEY (`flight_id`)
    REFERENCES `flight_booking`.`flight` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);