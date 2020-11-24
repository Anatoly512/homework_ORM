
-- Добавить поле (date - дата) в таблицу Projects


ALTER TABLE projects ADD COLUMN date date;


UPDATE projects SET date = '2019-08-25'
WHERE id = 1;

UPDATE projects SET date = '2018-11-02'
WHERE id = 2;

UPDATE projects SET date = '2019-10-30'
WHERE id = 3;

UPDATE projects SET date = '2018-05-11'
WHERE id = 4;

UPDATE projects SET date = '2017-02-19'
WHERE id = 5;

