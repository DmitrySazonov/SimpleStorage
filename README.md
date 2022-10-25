# SimpleStorage

## Description
It is a simple file saving service that saves files to the file system with a randomly generated id.
For correct operation, a folder tree is created according to the names of the files.

## Storage path
The value of the save folder in the parameter file.storage.path in application.properties

## API
### Save file
```json
POST /store
```
with a Multipart parameter with name **file**

In result will be a stored file **_id_** (string)
### Get file
```json
GET /get/{id}
```


