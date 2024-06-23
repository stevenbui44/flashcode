const themes = {
    default: {
        '--background-color': '#f9f7f1',		// tan			(background)
        '--header-color': '#1a2a57',			// dark blue 	(header)
        '--assortment-background': '#ffffff',	// white 		(assortment main box)
        '--assortment-border': '#ddd',			// light grey 	(border)
        '--text-primary': '#333333',			// dark grey 	(main text)
        '--text-secondary': '#666666',			// medium grey 	(description)
        '--card-count-background': '#f0f0f0',	// light grey	(assortment cards box)
        '--title-color': '#000000',
        '--no-description-color': '#999999',
        '--search-text-color': '#333333'
    },
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    dark: {
        '--background-color': '#232124',			// good
        '--header-color': '#302D32',				// good (?)
        
        '--assortment-background': '#38353A',
        '--card-count-background': '#6c6472',
        '--assortment-border': '#0f1122',
        
        '--title-color': '#E1E1E1',					// good
        '--text-primary': '#E1E1E1',
        '--text-secondary': '#E1E1E1',
        '--no-description-color': '#E1E1E1',
        '--search-text-color': '#E1E1E1',			// good
        
        '--search-input-background': '#E1E1E1',
        '--search-input-text': '#333333',
        '--search-input-placeholder': '#999999',
        
        '--button-text': '#E1E1E1',
        
        '--username-text': '#ffffff',
        '--profile-pic-background': '#808080',
        '--profile-pic-text': '#ffffff'
    },
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    light: {
        '--background-color': '#ffffff',
        '--header-color': '#111951',
        '--assortment-background': '#f9f9f9',
        '--assortment-border': '#e0e0e0',
        '--text-primary': '#333333',
        '--text-secondary': '#666666',
        '--card-count-background': '#f0f0f0',
        '--title-color': '#000000',
        '--no-description-color': '#999999',
        '--search-text-color': '#ffffff',
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
