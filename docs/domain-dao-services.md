to DTO or not to DTO
https://stackoverflow.com/questions/36174516/rest-api-dtos-or-not
see http://mapstruct.org/

GormInstanceApi
http://www.tothenew.com/blog/hooking-into-the-instance-methods-of-the-gorm-api/

Reason for DAO
- easily allows mods to persistence without needing the domain source. for example, if I have a Thing domain in my things plugin and need to customize the logic for insert in my app, I can create a ThingDao in my app to override the existing dao that may already be there in the things plugin. 
- Problems with doing more advanced beforeInsert, beforeUpdate, etc with the build in GORM. As said 
  > Do not attempt to flush the session within an event (such as with obj.save(flush:true)). Since events are fired during flushing this will cause a StackOverflowError."

  we ran into a number of problems, as many do, with session managment here. 
  A dao service creates simple centraolized contract for how to do this without suffering from the session limitations in hibernate/gorm
  
- we 