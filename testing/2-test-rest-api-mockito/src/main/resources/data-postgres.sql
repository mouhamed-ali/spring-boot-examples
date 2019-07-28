
-- github_user
INSERT INTO github_user (id,creation_date,email,location,login,name,type,url)
    VALUES (33104318, '2017-10-25 13:55:55', 'info@pivotal.io', 'San Francisco, CA',
    'pivotal','Pivotal','Organization','https://api.github.com/users/pivotal');


INSERT INTO github_user (id,creation_date,email,location,login,name,type,url)
    VALUES (41930, '2008-12-21 13:55:55', null, null,
    'spring','Spring RTS','Organization','https://api.github.com/users/spring');


INSERT INTO github_user (id,creation_date,email,location,login,name,type,url)
    VALUES (16627692, '2016-01-09 13:55:55', null, null,
    'amdouni-mohamed-ali',null,'User','https://api.github.com/users/amdouni-mohamed-ali');

-- github_repository
INSERT INTO github_repository(id,default_branch,description,fork,full_name,language,name,url,user_id)
    VALUES (188292833, 'master', null, false, 'pivotal/.github', null ,'.github' ,'https://api.github.com/repos/pivotal/.github', 33104318);

INSERT INTO github_repository(id,default_branch,description,fork,full_name,language,name,url,user_id)
    VALUES (2017841, 'master', null, true, 'spring/assimp', 'C++' ,'assimp' ,'https://api.github.com/repos/spring/assimp', 41930);

INSERT INTO github_repository(id,default_branch,description,fork,full_name,language,name,url,user_id)
    VALUES (128975740, 'master', null, true, 'amdouni-mohamed-ali/java6-rest-clients', 'Java' ,'java6-rest-clients' ,'https://api.github.com/repos/spring/assimp', 16627692);

INSERT INTO github_repository(id,default_branch,description,fork,full_name,language,name,url,user_id)
    VALUES (158075523, 'master', null, false, 'amdouni-mohamed-ali/jasper-reports-tutorial', 'Java' ,'jasper-reports-tutorial' ,'https://api.github.com/repos/amdouni-mohamed-ali/jasper-reports-tutorial', 16627692);

