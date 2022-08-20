import React, {useRef} from "react"
import './DataInput.css'
import PropTypes from 'prop-types'

const inputOnChange = () => {
}

const DataInput=({label_text,input_ref,input_onChange})=> {
    return(
        <>
        <div className="datainput_wrapper">
            <div className="input-data">
                <input className="datainput_input" type="text" onChange={input_onChange} ref={input_ref}/>
                <label className="datainput_label">{label_text}</label>
            </div>
        </div>
        </>
    )
}

DataInput.propTypes = {
    label_text:PropTypes.string,
    input_onChange:PropTypes.func
  }
  
  DataInput.defaultProps = {
    label_text:"word",
    input_onChange:inputOnChange
  }

export default DataInput