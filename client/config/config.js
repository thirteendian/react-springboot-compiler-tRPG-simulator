const fs = require('fs');

fs.copyFile('src/main/frontend/src/index.html', 'build/www/index.html', (err) => {
    if (err) {
        throw err;
    }
    console.log('Copied index.html!');
});