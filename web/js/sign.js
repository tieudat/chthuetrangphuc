/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

let container = document.getElementById('container')

toggle = ()=>{
	container.classList.toggle('sign-in')
	container.classList.toggle('sign-up')
}
setTimeout(()=>{
	container.classList.add('sign-up')
},200)
