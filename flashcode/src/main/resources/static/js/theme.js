const themes = {
	default: {
        '--background-color': '#232124',
        '--header-color': '#302D32',
        
        '--assortment-background': '#38353A',
        '--card-count-background': '#6c6472',
        '--assortment-border': '#0f1122',
        '--ellipsis-color': '#B5A9BD',
        
        '--title-color': '#E1E1E1',
        '--text-primary': '#E1E1E1',
        '--text-secondary': '#E1E1E1',
        '--no-description-color': '#E1E1E1',
        '--search-text-color': '#E1E1E1',
        '--no-assortments-text': '#E1E1E1',
        
        '--search-input-background': '#E1E1E1',
        '--search-input-text': '#333333',
        '--search-input-placeholder': '#999999',
        
        '--button-text': '#E1E1E1',
        
        '--username-text': '#ffffff',
        '--profile-pic-background': '#808080',
        '--profile-pic-text': '#ffffff',
        '--flashcode-title-color': '#ffffff'
    },
    light: {
        '--header-color': '#4F5459',
        '--background-color': '#E1E1E1',
        
        '--assortment-background': '#EFEFEF',
        '--card-count-background': '#B8BEC4',
        '--assortment-border': '#E1E1E1',
        
        '--title-color': '#443E46',
        '--text-primary': '#443E46',
        '--text-secondary': '#443E46',
        '--no-description-color': '#443E46',
        '--search-text-color': '#443E46',
        '--no-assortments-text': '#333333',
        
        '--search-input-background': '#EFEFEF',
        '--search-input-text': '#333333',
        '--search-input-placeholder': '#999999',
        
        '--button-text': '#EFEFEF',
        
        '--username-text': '#ffffff',
        '--profile-pic-background': '#808080',
        '--profile-pic-text': '#ffffff'
    }
};

function setTheme(themeName) {
    const theme = themes[themeName];
    Object.keys(theme).forEach(key => {
        document.documentElement.style.setProperty(key, theme[key]);
    });
}

document.addEventListener('DOMContentLoaded', function() {
    const savedTheme = localStorage.getItem('theme') || 'default';
    setTheme(savedTheme);
});

function applyTheme() {
    const savedTheme = localStorage.getItem('theme') || 'default';
    setTheme(savedTheme);
}

// Apply the theme when the page loads
document.addEventListener('DOMContentLoaded', applyTheme);
