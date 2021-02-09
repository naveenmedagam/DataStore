# DataStore

Request Curls for APIs

Save Task

curl -X POST \
  http://localhost:9091/api/store \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: af796267-0caa-0069-5af3-6d77e8ee24c6' \
  -d '  {
    "channel": null,
    "conversationId": null,
    "country": null,
    "json_data": {
        "blob": "eyJvcmdfaWQiOiI2aXhucW5teSIsImFwaV9rZXkiOiIiLCJzZXNzaW9uX2lkIjoid2ViLWMxNjk2ODk5LWQwMTUtNDdjOS05NDcyLTlhNjY1ZTI4Y2VmOTE2MTIzNjk1OTQ3OTkiLCJhcGlfdHlwZSI6InNlc3Npb24tcXVlcnkiLCJzZXJ2aWNlX3R5cGUiOiJhbGwiLCJldmVudF90eXBlIjoibG9naW4iLCJwb2xpY3kiOiJ3dV9sb2dpbiIsInBhZ2VfaWQiOiIxIiwiaW5wdXRfaXBfYWRkcmVzcyI6IjI0NS4yNCiaWxlX2Jyb3dzZXIiLCJ3ZWJfc2Vzc2lvbl9pZCI6IndlYi1jMTY5Njg5OS1kMDE1LTQ3YzktOTQ3Mi05YTY2NWUyOGNlZjkiLCJvdXRwdXRfZm9ybWF0IjoianNvbiJ9",
        "type": "THREAT_MET"
    },
    
    "security": {
        "client_ip": "172058014251",
        "auth_token": "web-c1696899-d015-47c9-9472-9a665e28cef9"
    }
}'

Update Task

curl -X PUT \
  http://localhost:9091/api/task/update \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 618d2111-4845-b668-787b-4531b2615f05' \
  -d '{
    "created_at": "1612851778486",
    "expiring_at": "1612851778486",
    "type": "THREAT_MET",
    "updated_at": "1612851778486",
    "task_token": "dd8e390f-c206-4cb6-a558-58d2c6d9e933",
    "security": {
        "client_ip": "172058014251",
        "auth_token": "web-c1696899-d015-47c9-9472-9a665e28cef9"
    }
}'


Get All Tasks // for  test

curl -X GET \
  http://localhost:9091/api/tasks \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 72a1b781-14bb-325b-20d1-10a9c33a0edf'
