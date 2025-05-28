-- Step 1: Add the column
ALTER TABLE refresh_token
ADD COLUMN user_id INT;

-- Step 2: Add the foreign key constraint
ALTER TABLE refresh_token
ADD CONSTRAINT fk_user_refresh_token
FOREIGN KEY (user_id)
REFERENCES users(id)
ON DELETE CASCADE;
