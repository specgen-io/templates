import Koa from 'koa';
import bodyParser from 'koa-bodyparser';
import Router from '@koa/router';

{{#swagger.value}}
import {koaSwagger} from 'koa2-swagger-ui';
import yamljs from 'yamljs';
{{/swagger.value}}

import {specRouter} from './spec/spec_router';

import { services } from './services';

const app = new Koa();
app.use(bodyParser({enableTypes: ['json', 'form', 'text']}));

let docsRouter = new Router()
{{#swagger.value}}
docsRouter.get('/docs', koaSwagger({swaggerOptions: {spec: yamljs.load("./docs/swagger.yaml")}}));
{{/swagger.value}}
app.use(docsRouter.routes());

let router = specRouter(services)
app.use(router.routes()).use(router.allowedMethods())

const port = 8081;
app.listen(port, () => {
    console.log( `server started at http://localhost:${ port }` );
})