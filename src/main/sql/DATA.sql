INSERT INTO sys_dept (sys_dept_id, parent_dept_id, name)
VALUES  ('020', NULL, 'Board'),
        ('021', NULL, 'Production Department'),
        ('022', NULL, 'Tech Department'),
        ('023', '022', 'Dev Department'),
        ('024', '022', 'Test Department');

INSERT INTO sys_user_role_rel (sys_user_id, sys_role_id)
VALUES  ('001', '011'),
        ('002', '012'),
        ('003', '013'),
        ('004', '013'),
        ('005', '012');

INSERT INTO sys_user (sys_user_id, name)
VALUES  ('001', 'Boss Smith'),
        ('002', 'Architect Zhang'),
        ('003', 'Developer John'),
        ('004', 'Tester Lmao'),
        ('005', 'Product Karli');

INSERT INTO sys_user_dept_rel (sys_user_id, sys_dept_id)
VALUES  ('001', '020'),
        ('002', '022'),
        ('003', '023'),
        ('004', '024'),
        ('005', '021');

INSERT INTO sys_role (sys_role_id, name)
VALUES  ('011', 'System Administrator'),
        ('012', 'Department Administrator'),
        ('013', 'General Staff');