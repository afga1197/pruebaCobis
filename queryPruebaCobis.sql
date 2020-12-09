use PruebaCobis;
create table libro (idLibro int identity primary key, nombreLibro nvarchar(150) unique,
descripcion nvarchar(300), autor nvarchar(150), fechaPublicacion date,
numeroEjemplares int, costo decimal(6,4));