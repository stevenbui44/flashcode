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
	    '--flashcode-title-color': '#ffffff',
	    
	    '--card-background': '#302D32',
	    '--card-order-background': '#444046',
	    '--form-control-background': '#4E4A50',
	    '--delete-button-color': '#888',
	    '--delete-button-hover-color': '#ff4444',
	    '--vertical-divider-color': '#ccc',
	    
	    '--card-order-color': '#E1E1E1',
	    '--card-order-border-color': '#ddd',
	    '--code-textarea-color': '#E1E1E1',
	    '--description-container-color': '#E1E1E1',
	    '--description-input-border-color': '#ccc',
	    '--form-label-color': '#E1E1E1',
	    '--header-divider-color': '#ccc',
	    '--input-label-color': '#E1E1E1',
	    '--no-description-color': '#999',
	    '--profile-pic-hover-color': '#666666',
	    '--card-shadow-color': 'rgba(0, 0, 0, 0.2)',
	    
	    // New colors
	    
	    '--card-border-color': 'rgba(255,255,255,0.125)',
	    '--progress-bar-background': '#4E4A50',
	    '--progress-fill-color': '#6c6472',
	    '--progress-text-color': '#E1E1E1',
	    '--stat-label-color': '#B5A9BD',
	    '--stat-value-color': '#E1E1E1',
	    '--return-link-color': '#3498db',
	    '--button-primary-color': '#3498db',
	    '--button-success-color': '#2ecc71',
	    '--button-warning-color': '#f39c12',
	    '--button-danger-color': '#e74c3c',
	    '--card-background-bright': '#464248',
	    '--button-hover-brightness': 1.3,
	    '--text-brightest': '#FFFFFF',
	    '--button-hover-background': '#302D32',
	    '--hover-brightness': '150%',
	    '--progress-fill-color': '#6c6472',
	    '--progress-fill-hover-color': '#5a5460',
	    
	    '--notes-background': '#38353A',
	    '--notes-text-color': '#FFFFFF',
	    '--notes-placeholder-color': '#B5A9BD'
    },
    light: {
	    '--background-color': '#E1E1E1',
	    '--header-color': '#4F5459',
	
	    '--assortment-background': '#EFEFEF',
	    '--card-count-background': '#B8BEC4',
	    '--assortment-border': '#E1E1E1',
	    '--ellipsis-color': '#7A7A7A',
	
	    '--title-color': '#443E46',
	    '--text-primary': '#443E46',
	    '--text-secondary': '#666666',
	    '--no-description-color': '#443E46',
	    '--search-text-color': '#443E46',
	    '--no-assortments-text': '#333333',
	
	    '--search-input-background': '#EFEFEF',
	    '--search-input-text': '#333333',
	    '--search-input-placeholder': '#999999',
	
	    '--button-text': '#EFEFEF',
	
	    '--username-text': '#ffffff',
	    '--profile-pic-background': '#808080',
	    '--profile-pic-text': '#ffffff',
	    '--flashcode-title-color': '#ffffff',
	
	    '--card-background': '#E3E5E6',
	    '--card-order-background': '#E2E7E9',
	    '--form-control-background': '#F5F5F5',
	    '--delete-button-color': '#888',
	    '--delete-button-hover-color': '#ff4444',
	    '--vertical-divider-color': '#CCCCCC',
	
	    '--card-order-color': '#333333',
	    '--card-order-border-color': '#CCCCCC',
	    '--code-textarea-color': '#333333',
	    '--description-container-color': '#443E46',
	    '--description-input-border-color': '#CCCCCC',
	    '--form-label-color': '#443E46',
	    '--header-divider-color': '#CCCCCC',
	    '--input-label-color': '#666666',
	    '--no-description-color': '#999999',
	    '--profile-pic-hover-color': '#A0A0A0',
	    '--card-shadow-color': 'rgba(0, 0, 0, 0.1)',
	    
	    // New colors
	    
	    '--card-border-color': 'rgba(0, 0, 0, 0.125)',
	    '--progress-bar-background': '#D0D0D0',
	    '--progress-fill-color': '#C3C3C3',
	    '--progress-text-color': '#FFFFFF',
	    '--stat-label-color': '#666666',
	    '--stat-value-color': '#443E46',
	    '--return-link-color': '#3498db',
	    '--button-primary-color': '#3498db',
	    '--button-success-color': '#2ecc71',
	    '--button-warning-color': '#f39c12',
	    '--button-danger-color': '#e74c3c',
	    '--card-background-bright': '#F0F0F0',
	    '--button-hover-brightness': 0.9,
	    '--text-brightest': '#000000',
	    '--button-hover-background': '#E0E0E0',
	    '--hover-brightness': '80%',
  		'--progress-fill-hover-color': '#A8A8A8',
	
	    '--notes-background': '#F5F5F5',
	    '--notes-text-color': '#333333',
	    '--notes-placeholder-color': '#999999'
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
