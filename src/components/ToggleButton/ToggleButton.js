import './ToggleButton.css'

const ToggleButton = ({onClick,active}) =>{
    return(
        <>
        <label className="switch">
        <input checked={active} onClick={onClick} className='toggle_input' type="checkbox"/>
        <span className="slider round"></span>
        </label>
        </>
    )
}

export default ToggleButton