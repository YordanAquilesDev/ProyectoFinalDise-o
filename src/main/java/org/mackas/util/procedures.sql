/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Administrador
 * Created: 22 oct. 2026
 */
USE DB_universidad;

DELIMITER //

CREATE PROCEDURE sp_login(
    IN p_username VARCHAR(50),
    IN p_password VARCHAR(255)
)
BEGIN
    SELECT 
        id_usuario,
        username,
        password_hash,
        rol,
        estado
    FROM usuario
    WHERE username = p_username 
      AND password_hash = p_password 
      AND estado = TRUE;
END //

DELIMITER ;
