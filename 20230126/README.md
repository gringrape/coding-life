# Message queue tutorial
- round robin 
- acknowledge

## round robin
- sender 에서 지속적으로 message queue에 message를 쌓는다. 
- worker 두개를 실행해서 어떤 메시지가 처리되는지 관찰한다. 
- 메시지마다 고유값이 있어야 관찰이 가능하므로 이름을 붙여준다. 
