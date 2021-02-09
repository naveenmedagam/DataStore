DROP TABLE IF EXISTS task;

CREATE TABLE task (
  task_token VARCHAR(250)   PRIMARY KEY,
  channel VARCHAR(250),
  created_at LONG,
  expiring_at LONG,
  updated_at LONG,
  type VARCHAR(250),
  data VARCHAR(750),
  status VARCHAR(250)
  
);
