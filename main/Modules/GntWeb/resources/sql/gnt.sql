CREATE DATABASE `gnt` DEFAULT CHARACTER SET utf8;

CREATE TABLE `gnt_book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` char(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `gnt_word` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_name` char(36) NOT NULL,
  `chapter` int(11) NOT NULL,
  `verse` int(11) NOT NULL,
  `sequence` int(11) NOT NULL,
  `text` varchar(100) DEFAULT NULL,
  `normalized_text` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `morph_tag` varchar(100) DEFAULT NULL,
  `number` varchar(100) DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `word_case` varchar(100) DEFAULT NULL,
  `tense` varchar(100) DEFAULT NULL,
  `voice` varchar(100) DEFAULT NULL,
  `mood` varchar(100) DEFAULT NULL,
  `strong` int(11) DEFAULT NULL,
  `lemma` char(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6816 DEFAULT CHARSET=utf8;
