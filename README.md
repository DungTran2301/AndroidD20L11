# AndroidD20L11

# HomeFragment (Khi khởi động app)
![image](https://user-images.githubusercontent.com/84552830/182117917-70b880e6-8f51-42c1-a771-d1fa3376822f.png)

# PlayFragment (Gồm TabLayout + ViewPager2 chứa 2 Tabs là FavoriteFragment và YourMusicFragment)
![image](https://user-images.githubusercontent.com/84552830/182118001-d8d62b59-dddd-434d-918d-fda00fcd8eac.png)
![image](https://user-images.githubusercontent.com/84552830/182118046-ec0e69d8-8f7a-4fbc-b2a8-d62cd9cb8352.png)

# SettingFragment (Hiển thị thông tin người dùng ban đầu - được fix cứng)
![image](https://user-images.githubusercontent.com/84552830/182118117-044f6f2d-d6af-43c8-a984-7bdeec91da90.png)

//(Sau khi nhấn Edit ở SettingFragment sẽ thực hiện việc điều hướng thông qua Navigation Controller, khi navigate sẽ gửi kèm 1 bundle gán cho argument ở EditFragment)

# EditFragment (Nơi sửa thông tin người dùng)
![image](https://user-images.githubusercontent.com/84552830/182118191-e153c5d3-b816-4c92-8d8b-0e081c5579c7.png)

//Sau khi nhấn nút Save, thông tin người dùng sẽ được lưu lại, đồng thời setFragmentResult(Bundle(chứa dữ liệu mới)) để trả dữ liệu về cho listener ở SettingFragment, cuối cùng sẽ điều hướng ngược trở lại SettingFragment thông qua Navigation Controller.
![image](https://user-images.githubusercontent.com/84552830/182118225-e3b93f4b-0eb1-4bf6-b462-bbd6f7c42d97.png)
