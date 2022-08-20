import './ThreeOptions.css'
import React from 'react'
import PropTypes from 'prop-types'

const ThreeOptions = ({question,name,html_for1,html_for2,html_for3,optionOnChange})=> {
    return(
        <>
      <div onChange={optionOnChange} className="threeoption3-radio-container">
        <h5>{question}</h5>
      <input value={"Katılıyorum"} className='threeoption3_input' type="radio" id={html_for1} name={name} />
      <label className='threeoption3_label' htmlFor={html_for1}>Katılıyorum</label>

      <input value={"Emin Değilim"} className='threeoption3_input' type="radio" id={html_for2} name={name} />
      <label className='threeoption3_label' htmlFor={html_for2}>Emin Değilim</label>

      <input value={"Katılmıyorum"} className='threeoption3_input' type="radio" id={html_for3} name={name} />
      <label className='threeoption3_label' htmlFor={html_for3}>Katılmıyorum</label>

      <hr className='horizontal'/>
    </div>
        </>
    )
}

ThreeOptions.propTypes = {
    question:PropTypes.string
  }
  
ThreeOptions.defaultProps = {
    question:"Selamun Aleyküm"
  }

export default ThreeOptions