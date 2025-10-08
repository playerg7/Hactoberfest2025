export function login(username) {
    localStorage.setItem('user', username);
}

export function logout() {
    localStorage.removeItem('user');
}

export function getCurrentUser() {
    return localStorage.getItem('user');
}

export function isLoggedIn() {
    return !!localStorage.getItem('user');
}
