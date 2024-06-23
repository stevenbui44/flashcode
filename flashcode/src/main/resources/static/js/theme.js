const themes = {
    //default: {
    //    '--background-color': '#f9f7f1',		// tan			(background)
    //    '--header-color': '#1a2a57',			// dark blue 	(header)
    //    '--assortment-background': '#ffffff',	// white 		(assortment main box)
    //    '--assortment-border': '#ddd',			// light grey 	(border)
    //    '--text-primary': '#333333',			// dark grey 	(main text)
    //    '--text-secondary': '#666666',			// medium grey 	(description)
    //    '--card-count-background': '#f0f0f0',	// light grey	(assortment cards box)
    //    '--title-color': '#000000',
    //    '--no-description-color': '#999999',
    //    '--search-text-color': '#333333'
    //},
    
    default: {
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
    },
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    dark: {
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
