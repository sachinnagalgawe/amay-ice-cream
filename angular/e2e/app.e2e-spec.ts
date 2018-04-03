import { AmayIceCreamAngularPage } from './app.po';

describe('amay-ice-cream-angular App', function() {
  let page: AmayIceCreamAngularPage;

  beforeEach(() => {
    page = new AmayIceCreamAngularPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
