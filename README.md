# Spring boot chat application

## tools
$ pip install websockets-cli
$ ws install-completion




  A convenient websocket cli.

  Example usage:

  # listens incoming messages from endpoint ws://localhost:8000/path
  $ ws listen ws://localhost:8000/path

  # sends text "hello world" in a text frame
  $ ws text wss://ws.postman-echo.com/raw "hello world"

  # sends the content from json file "hello.json" in a binary frame
  $ ws byte wss://ws.postman-echo.com/raw file@hello.json

## ECHO SERVER 

$ ws echo-server -H ::1 -p 8000

# OUVINDO
# assuming you have an endpoint localhost:8000 sending messages
$ ws listen :8000
# you will have an output like the following
──────────────────── TEXT message on 2022-05-25 07:10:07 ────────────────────────────────────
{"hello": "world"}
──────────────────── BINARY message on 2022-05-25 07:10:07 ──────────────────────────────────────
b'{"hello": "world"}'