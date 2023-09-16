# Lifeline: Your Digital Health Companion

Lifeline is a state-of-the-art health application designed to simplify prescription management while integrating seamlessly with the ABHA API. Built using Spring Boot and Thymeleaf, and compatible with Java 17, Lifeline offers a robust and user-friendly platform for all your health management needs.

## Authentication

Lifeline prioritizes user security and convenience. Users can authenticate using:

- **Username and Password**: Traditional authentication method ensuring security and simplicity.
- **Google OAuth**: For users preferring to use their Google accounts, Lifeline integrates seamlessly with Google OAuth, providing a smooth login experience.

### Setting up Google OAuth

1. Go to the [Google Developers Console](https://console.developers.google.com/).
2. Create a new project.
3. Navigate to the **Credentials** tab and click on **Create Credentials**.
4. Select **OAuth 2.0 Client IDs**.
5. Choose **Web application** and set the redirect URIs for your environment.
6. Once created, you'll receive your `Client ID` and `Client Secret`.

### Configuring Lifeline with Google OAuth

1. Rename `application.properties.examples` to `application.properties`.
2. Update the values in `application.properties` with your Google OAuth `Client ID` and `Client Secret`:

```
google.oauth2.client.id=YOUR_GOOGLE_CLIENT_ID
google.oauth2.client.secret=YOUR_GOOGLE_CLIENT_SECRET
```

## Tech Stack

- **Spring Boot**: For the backend framework.
- **Thymeleaf**: Server-side Java template engine for web applications.
- **Java 17**: Ensuring the latest features and optimizations.
