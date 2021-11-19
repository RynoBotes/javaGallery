import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { BASE_API_URL } from 'src/environments/environment';
import {  FormGroup, ReactiveFormsModule } from '@angular/forms';


@Component({
  selector: 'app-image-upload',
  templateUrl: './image-upload.page.html',
  styleUrls: ['./image-upload.page.scss'],
})
export class ImageUploadPage implements OnInit{
  uploadForm: FormGroup;  

  constructor(private modalController:ModalController, private httpClient: HttpClient) {
    
   }
   ngOnInit() {
    
  }
  onFileSelect(event) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.uploadForm.get('profile').setValue(file);
    }
  }
  

  addphoto= ()=>{
    // ev.preventDefault();
  let photo ={
    id:  (<HTMLInputElement>document.getElementById('memberId')).value,
   blobLocation: (<HTMLInputElement>document.getElementById('bloblocation')).value,
   photoName: (<HTMLInputElement>document.getElementById('photoName')).value,
   photoDiscription: (<HTMLInputElement>document.getElementById('photoDescription')).value
  }
    
  
    fetch(BASE_API_URL+"photo-map",{method:'POST',body: JSON.stringify(photo),headers: {
      'Content-type': 'application/json; charset=UTF-8'
    }
  }).then(function (response) {
    if (response.ok) {
      return response.json();
    }
    return Promise.reject(response);
  }).then(function (data) {
    console.log(data);
  }).catch(function (error) {
    console.warn('Something went wrong.', error);
  });;
    console.warn(JSON.stringify(photo));
   ////////////////////
   const formData = new FormData();
    formData.append('file', this.uploadForm.get('profile').value);

    this.httpClient.post<any>(BASE_API_URL+"photo-map/uploadImage", formData).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );
    
  
  }

  deletePhoto = () =>{
    let id;

    id = (<HTMLInputElement>document.getElementById('photoId')).value,


    fetch(BASE_API_URL+"photo-map/delete/"+id, {headers: {
    'Content-type': 'application/json; charset=UTF-8'
  }
})
.then(res => res.text()) // or res.json()
.then(res => console.log(res))
  }

}
