// Spend more time programming. One command for an instant, secure URL to your localhost server through any NAT or firewall.

// ngork is used for exposing public URLs to your localhost Web Server.

const url = require('url');
const http = require('http');
const server = http.createServer((req, res) =>
{
    let data = []
    req.on('data', chunk => {
      data.push(chunk)
    })
    req.on('end', () => {
        console.log(JSON.parse(data));
    })
    res.end();
  })
  server.listen(3000);