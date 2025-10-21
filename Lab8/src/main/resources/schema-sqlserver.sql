if not exists (select 1 from sys.objects where object_id = object_id(N'[dbo].[accounts]') and type in (N'U'))
begin
    create table dbo.accounts (
        username nvarchar(50) not null primary key,
        password nvarchar(255) not null,
        fullname nvarchar(100) not null,
        admin bit not null
    );
end


