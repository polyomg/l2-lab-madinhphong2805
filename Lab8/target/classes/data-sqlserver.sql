merge dbo.accounts as target
using (values
    (N'user', N'123', N'Normal User', cast(0 as bit)),
    (N'admin', N'123', N'Administrator', cast(1 as bit))
) as src(username, password, fullname, admin)
on target.username = src.username
when not matched then
    insert (username, password, fullname, admin)
    values (src.username, src.password, src.fullname, src.admin);


