import { useState, useEffect } from 'react';
import Cookies from 'js-cookie';

export function useCookie(key: string, initialValue: any) {
  const [value, setValue] = useState(() => {
    const cookieValue = Cookies.get(key);
    return cookieValue !== undefined ? JSON.parse(cookieValue) : initialValue;
  });

  useEffect(() => {
    Cookies.set(key, JSON.stringify(value));
  }, [key, value]);

  return [value, setValue];
}
