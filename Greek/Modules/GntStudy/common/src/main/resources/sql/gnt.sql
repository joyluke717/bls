DROP SCHEMA IF EXISTS  `gnt`;

CREATE SCHEMA `gnt` DEFAULT CHARACTER SET utf8;

use gnt;

CREATE TABLE `gnt`.`gnt_book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `short_name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `gnt`.`gnt_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` char(36) NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `gnt`.`gnt_word` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_short_name` varchar(10) NOT NULL,
  `chapter_number` int(11) NOT NULL,
  `verse_number` int(11) NOT NULL,
  `sequence_number` int(11) NOT NULL,
  `text` varchar(100) NOT NULL,
  `word` varchar(100) NOT NULL,
  `normalized_text` varchar(100) DEFAULT NULL,
  `lemma` char(100) DEFAULT NULL,
  `part_of_speech` varchar(100) DEFAULT NULL,
  `morph_tag` varchar(100) DEFAULT NULL,
  `person` varchar(100) DEFAULT NULL,
  `number` varchar(100) DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `word_case` varchar(100) DEFAULT NULL,
  `tense` varchar(100) DEFAULT NULL,
  `voice` varchar(100) DEFAULT NULL,
  `mood` varchar(100) DEFAULT NULL,
  `degree` varchar(100) DEFAULT NULL,
  `strong` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

Drop Table IF EXISTS `gnt`.`gnt_lexicon`;
CREATE TABLE `gnt`.`gnt_lexicon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `word` varchar(100) NOT NULL,
  `full_word` varchar(100) NULL,
  `meaning` varchar(4096) NOT NULL,
  `full_meaning` varchar(4096) NULL,
  `word_type` varchar(100) DEFAULT NULL,
  `strong_number` int(11) DEFAULT NULL,
  `frequency` integer DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;