alter table refresh_token drop column secret;


alter table users add column secret TEXT not null;