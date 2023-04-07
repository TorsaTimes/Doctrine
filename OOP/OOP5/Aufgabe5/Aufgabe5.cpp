#include "pch.h"
#include <iostream>
#include <array>
#include <random>
#include <map>
#include <algorithm>
#include <string>

void increment(int &i)
{
	++i;
}

int main()
{
	std::random_device seed;
	std::mt19937 engine(seed());
	std::uniform_int_distribution<int> six(0, 9);
	std::map<std::string, int> buch;
	std::multimap<int, std::string> häufigkeit;

	std::array<std::string, 10> arraywords = { "Hei", "wie", "gehts", "Elefant", "T-Rex", "Regex", "Praktikum", "Schnee", "Publikum", "Festival" };

	for (int i = 0; i < 100; i++)
	{
		std::string randword = arraywords[six(engine)];
		buch[randword]++;
		std::cout << randword;
	}
	std::cout << std::endl;

	for (int i = 0; i < 10; i++)
	{
		std::cout << arraywords[i] << ":\t\t" << buch[arraywords[i]] << " mal enthalten" << std::endl;
	}
	std::cout << std::endl;
	std::cout << "Alphabetisch ausgegeben" << std::endl;

	for (std::map<std::string, int>::const_iterator i = buch.begin(); i != buch.end(); ++i)
	{
		std::cout << i->first << ":\t" << i->second << std::endl;
	}

	std::cout << "Nach haeufigkeit ausgegeben" << std::endl;

	for (auto element : buch) {
		häufigkeit.emplace(element.second, element.first);
	}
	for (auto element : häufigkeit) {
		std::cout << element.first << " " << element.second << std::endl;
	}



	return 0;
}