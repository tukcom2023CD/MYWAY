import Cookies from 'js-cookie';

export function testCookie() {
  Cookies.set('myCookie', 'new value', { expires: 7 });
}
