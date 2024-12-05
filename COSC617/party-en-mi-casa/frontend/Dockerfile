###############################################################
# DOCKERFILE
#
# @author Emmanuel Taylor
#
# @description
#   Provides a set of instructions for the creation of the
#   docker image for the application's front end.
###############################################################

# Build the Node.js application.
FROM node:22 AS build

# Set the working directory inside the container.
WORKDIR /app/src

# Copy package.json and package-lock.json to the container.
COPY package*.json ./

# Installs dependencies using the lock file as a clean installation.
RUN npm ci

# Copy the rest of the application code to the container.
COPY . .

# Build a production-ready app to the "dist" folder.
RUN npm run build

# Serve the built application with Nginx.
FROM docker.io/nginx

# Copy the built application to the Nginx HTML directory.
COPY --from=build /app/src/dist /usr/share/nginx/html

# Copy a custom Nginx configuration file. (Optional)
#COPY nginx.conf /etc/nginx/conf.d/default.conf

# Expose port 80 for incoming HTTP traffic.
EXPOSE 80

# Command to start Nginx in the foreground.
CMD ["nginx", "-g", "daemon off;"]