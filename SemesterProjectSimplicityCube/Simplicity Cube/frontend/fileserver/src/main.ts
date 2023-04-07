import dotenv from 'dotenv';
import express from 'express';

// initialize configuration
dotenv.config();

const port = process.env.SERVER_PORT;
const app = express();
const dir = `${__dirname}/public/`;

// parse application/x-www-form-urlencoded
app.use(express.urlencoded({ extended: false }));
app.use(express.static(dir));

app.get('/', (req, res) => {
  res.sendFile(dir + 'index.html');
});

// start the express server
app.listen(port, () => {
  console.log(`Server started at http://localhost:${port}`);
});
