CREATE OR REPLACE VIEW v_user_function_prvg AS
SELECT su.sys_user_id, sf.*
FROM sys_privilege prv
LEFT JOIN sys_user su
  ON prv.subject_type = 'user'
  AND prv.subject_id = su.sys_user_id
LEFT JOIN sys_function sf
  ON prv.object_type = 'function'
  AND (prv.object_id = '*' OR prv.object_id = sf.sys_function_id)
;