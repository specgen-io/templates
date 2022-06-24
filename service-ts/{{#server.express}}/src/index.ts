import express from 'express';
import cors from 'cors';
{{#swagger.value}}
import swaggerUi from 'swagger-ui-express';
import yamljs from 'yamljs';
{{/swagger.value}}

import { specRouter } from './spec/spec_router';

import {sampleService} from './sample_service';

const app = express();
const port = 8081;

app.use(cors())
app.use(express.json())
app.use(express.text())

{{#swagger.value}}
app.use("/docs/swagger.yaml", express.static("docs/swagger.yaml"))
app.use("/docs", swaggerUi.serve, swaggerUi.setup(yamljs.load("./docs/swagger.yaml")))
{{/swagger.value}}

const services = {sampleService: sampleService()}
let router = specRouter(services)
app.use("/", router)

app.listen(port, () => {
    console.log( `server started at http://localhost:${ port }` );
});