<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
</body>

<script language="javascript"type="text/javascript">  
    var wsUri ="ws://127.0.0.1:8080/websocket/websocket.ws/relationId/12345"; 
    var output;  
    
    function init() { 
        output = document.getElementById("output"); 
        testWebSocket(); 
    }  
 
    function testWebSocket() { 
        websocket = new WebSocket(wsUri); 
        websocket.onopen = function(evt) { 
            onOpen(evt) 
        }; 
        websocket.onclose = function(evt) { 
            onClose(evt) 
        }; 
        websocket.onmessage = function(evt) { 
            onMessage(evt) 
        }; 
        websocket.onerror = function(evt) { 
            onError(evt) 
        }; 
    }  
 
    function onOpen(evt) { 
        writeToScreen("CONNECTED"); 
        doSend("客户端发送给服务端"); 
    }  
 
    function onClose(evt) { 
        writeToScreen("关闭"); 
    }  
 
    function onMessage(evt) { 
        writeToScreen('<span style="color: blue;">接收到的数据：'+ evt.data+'</span>'); 
        //websocket.close(); 
    }  
 
    function onError(evt) { 
        writeToScreen('<span style="color: red;">错误:</span> '+ evt.data); 
    }  
 
    function doSend(message) { 
        writeToScreen("客户端发送: " + message);  
        websocket.send(message); 
    }  
 
    function writeToScreen(message) { 
        output.innerHTML = message; 
    }  
 
    window.addEventListener("load", init, false);  
</script>  
<h2>WebSocket Test</h2>  
<div id="output"></div> 
</html>
