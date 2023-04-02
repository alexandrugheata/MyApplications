import { Component, OnInit } from '@angular/core';
import { WeatherData } from './models/weather.model';
import { WeatherService } from './services/weather.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  constructor(private weatherService: WeatherService) {

  }
  //default city
  cityName: string = 'landon';
  weatherData?: WeatherData;

  ngOnInit(): void {
    // //apelam metoda din weather.services, de aceea i am facut un constructor
    // this.weatherService.getWeatherData('landon')
    // .subscribe({//subscribe to this method
    //   next: (response) => {
      
    //      this.weatherData = response;
    //      console.log(response);
    //   }

    // });
    this.getWeatherData(this.cityName);
    this.cityName = '';//pt a nu aparea in casuta de Search, numele orasului default=landon



  }
  onSubmit() {
    
    this.getWeatherData(this.cityName);
    this.cityName = '';

  }

  private getWeatherData(cityName: string) {
    //apelam metoda din weather.services, de aceea i am facut un constructor
    this.weatherService.getWeatherData(cityName)
    .subscribe({//subscribe to this method
      next: (response) => {
      
         this.weatherData = response;
         console.log(response);
      }

    });
  }

 
}
