import './DataButton.css'
import React from 'react'
import PropTypes from 'prop-types'

const buttonOnClick = () => {
    
}

const DataButton = ({button_text,button_onClick}) =>
{
  
    return(
        <>
        <a className='button databutton_button' onClick={button_onClick}>{button_text}</a>
        </>
    )
}

DataButton.propTypes = {
    button_text:PropTypes.string,
    button_onClick:PropTypes.func
  }
  
  DataButton.defaultProps = {
    button_text:"Press...",
    button_onClick: buttonOnClick 
  }

export default DataButton