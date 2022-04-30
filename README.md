# EditTextValidatorLibraryFull
library

![Untitled](https://user-images.githubusercontent.com/104067484/166117291-5d3e719b-5ca2-41f9-a117-74f3fcf03df1.png) 

![Untitled (1)](https://user-images.githubusercontent.com/104067484/166117344-a0da7cf3-d106-4818-aa5e-834aa29fd2ed.png)

# Password confirmation

val password:EditText = findViewById(R.id.password)
  
val rePassword:EditText = findViewById(R.id.rePassword)
  
EditValidator.passwordValidator(password, rePassword)

# Email confirmation

val email:EditText = findViewById(R.id.email)

EditValidator.emailAddress(email)

# IPAddress confirmation

val ipAddress:EditText = findViewById(R.id.ipAddress)

EditValidator.ipAddress(ipAddress)

# Telephone number confirmation

val telephoneNumber:EditText = findViewById(R.id.telephoneNumber)

EditValidator.telephoneNumber(telephoneNumber)

# Zip code confirmation

val zipCode:EditText = findViewById(R.id.zipCode)

EditValidator.zipCode(zipCode)

# Year of birth confirmation

val year:EditText = findViewById(R.id.year)

EditValidator.year(year)


# Maven

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  # Gradle
  
  dependencies {
  
	        implementation 'com.github.AkmalValiev:EditTextValidatorLibraryFull:1.1.2'
          
	}
