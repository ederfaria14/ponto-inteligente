


CREATE TABLE `empresa`(
    `id` BIGINT(255) NOT NULL,
    `cnpj` VARCHAR(255) NOT NULL,
    `data_atualizacao` DATETIME NOT NULL,
    `data_criacao` DATETIME NOT NULL,
    `razao_social` VARCHAR(255) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;