const themes = {
    default: {
        '--background-color': '#f9f7f1',
        '--header-color': '#1a2a57',
        '--assortment-background': '#ffffff',
        '--assortment-border': '#ddd',
        '--text-primary': '#333333',
        '--text-secondary': '#666666',
        '--card-count-background': '#f0f0f0'
    },
    dark: {
        '--background-color': '#2c2c2c',
        '--header-color': '#1a1a1a',
        '--assortment-background': '#3c3c3c',
        '--assortment-border': '#555',
        '--text-primary': '#ffffff',
        '--text-secondary': '#cccccc',
        '--card-count-background': '#4c4c4c'
    },
    light: {
        '--background-color': '#ffffff',
        '--header-color': '#4a90e2',
        '--assortment-background': '#f9f9f9',
        '--assortment-border': '#e0e0e0',
        '--text-primary': '#333333',
        '--text-secondary': '#666666',
        '--card-count-background': '#f0f0f0'
    }
};

function setTheme(themeName) {
    const theme = themes[themeName];
    Object.keys(theme).forEach(key => {
        document.documentElement.style.setProperty(key, theme[key]);
    });
    localStorage.setItem('theme', themeName);
}

function applyTheme() {
    const savedTheme = localStorage.getItem('theme') || 'default';
    setTheme(savedTheme);
}

// Apply the theme when the page loads
document.addEventListener('DOMContentLoaded', applyTheme);
