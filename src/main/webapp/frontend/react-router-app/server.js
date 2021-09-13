import express from 'express';
import cors from 'cors';

const express = require('express');
const cors = require('cors');
const app = express();

app.use(cors());

app.use('/login', (req, res) => { //the path the application will listen to // reqeust // result
    res.send({
      token: 'alicE'
    });
});

app.listen(9090, () => console.log('API is running on http://localhost:7777/login'));