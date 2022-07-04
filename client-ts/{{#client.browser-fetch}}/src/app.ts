import * as sample from './spec/sample';

declare global {
  interface Window {
    sampleClient: (config: {baseURL: string}) => sample.SampleClient
  }
}

window.sampleClient = sample.client