

CREATE TABLE usuarios_crud (
  usuario_id BIGINT(5) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  tipo VARCHAR(45) NULL,
  PRIMARY KEY (usuario_id));
  
  select * from usuarios_crud;
  
  INSERT INTO usuarios_crud(usuario_id, nombre, tipo) VALUES
  (101, 'Mama mia', 'drama'),
  (102, 'Mission Impossible', 'action'),
  (103, 'Coco', 'animation');